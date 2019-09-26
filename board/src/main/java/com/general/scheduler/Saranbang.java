package com.general.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class Saranbang {

    @Scheduled(cron = "3 * * * * *")
    public void trading() {
        System.out.println("scraping trading area ...  ");
    }

    @Scheduled(fixedDelay = 10 * 1000)
    public void fixedTiming(){
//        System.out.println(" fixed timing ( one Second ) ... ");
    }

    public void job(){
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("cmd.exe", "/c", "node -v");
        try {
            Process process = processBuilder.start();
            StringBuilder stringBuilder = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = "";
            while ( (line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }
            if (process.waitFor() == 0) {
                System.out.println(stringBuilder.toString());
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
