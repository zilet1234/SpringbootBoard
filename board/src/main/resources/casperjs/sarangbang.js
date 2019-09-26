var casper = require('casper').create({
    clientScripts:  ['path/jquery-3.3.1.min.js']
});

// CasperJS처리 시작
casper.start("http://home.sarangbang.com/linead/list.html?menu=house&submenu=sell&code_area1=1&code_area2=13");

// 사랑방 싸이트 열기
casper.then(function () {
    this.evaluate(function () {
        console.log( $("form[name=compare_apt_form]").text() );
    });
});

