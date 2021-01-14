package com.general.scheduler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.general.model.dao.table.domain.HouseInfo;
import com.general.model.dao.table.service.HouseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.*;
import java.time.LocalDateTime;

@Component
public class Sarangbang {

    @Autowired
    private HouseInfoService houseInfoService;

    private int index = 1;
    private int page = 1;

//    @Scheduled(cron = "3 * * * * *")
//    public void scheduling() {
//
//    }

    // 15 초 주기
    @Scheduled(fixedDelay = 15 * 1000)
    public void scraping() {
        try {
            jobPrccessExcute(Integer.toString(index), Integer.toString(page));
            index ++;

            if ( page == 10 ){
                return;
            }

            if ( index == 21 ) {
                index = 1;
                page ++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Scheduled(fixedDelay = 10 * 1000)
    public void store() {
        try {
            jobFileFound();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 스크랩핑 프로세스 실행 - 거래 정보
    private void jobPrccessExcute(String index, String page) throws IOException {
        String location = "z:/casperjs/source/TradingLand.js";
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("cmd.exe", "/c", "casperjs", location, index, page);
        processBuilder.start();
    }

    //
    private void jobFileFound() throws Exception{

        String location = "z:/casperjs/sample";
        String reNameLocation = "z:/casperjs/temp";

        File directory = new File(location);

        if( !directory.isDirectory() ) {
            throw new Exception("디렉토리가 존재 하지 않습니다.");
        }

        File[] fileArray = directory.listFiles();

        if ( fileArray == null || fileArray.length == 0 ) {
            return;
        }

        directory = new File(reNameLocation);
        if ( !directory.exists()){
            directory.mkdir();
        }

        // 파싱
        String fileName = fileArray[0].getName();
        ObjectMapper objectMapper = new ObjectMapper();
        HouseInfo houseInfo = objectMapper.readValue(fileArray[0], HouseInfo.class);

        LocalDateTime now = LocalDateTime.now();
        houseInfo.setWriteDT(now);
        houseInfo.setRegDT(now);
        houseInfo.setDelYN(false);

        // 저장
        if ( !saveHouseInfo(houseInfo) ) {
//            throw new Exception( fileName + " 의 데이터가  존재 합니다.");
            System.out.println( fileName + " 의 데이터가  존재 합니다.");
        }

        // 파일 이동
        File moveFile = new File(reNameLocation + "/" + fileName);
        moveFile(fileArray[0], moveFile);

    }

    // 부동산 거래 정보 저장
    private boolean saveHouseInfo(HouseInfo houseInfo) throws Exception {
        boolean isSuccess = false;

        // 1. 이미 존재하는 집 정보 인지 체크
        boolean isExist = houseInfoService.checkExist(houseInfo);

        if ( !isExist ) {
            // 2. 데이터 베이스에 저장
            houseInfoService.set(houseInfo);
            isSuccess = true;
        }

        return isSuccess;
    }

    // 파일 이동
    private void moveFile(File source, File dest) throws IOException{
        InputStream inStream = null;
        OutputStream outStream = null;

        // source 파일을 dest 파일로 복사
        try{
            inStream = new FileInputStream(source); //원본파일
            outStream = new FileOutputStream(dest); //이동시킬 위치
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inStream.read(buffer)) > 0){
                outStream.write(buffer, 0, length);
            }
        }catch(IOException e){
            throw new IOException(e);
        }finally{
            inStream.close();
            outStream.close();
        }

        // source 파일 삭제
        source.delete();
    }

}
