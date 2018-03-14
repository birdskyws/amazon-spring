var casper = require('casper').create();
var pic = casper.cli.get("pic");
var tid = casper.cli.get("tid");
var fs = require('fs');
var sellors;
var url = "https://www.amazon.com/gp/offer-listing/"+casper.cli.get("oid");
function getSellors() {  
    var rows = document.querySelectorAll(".olpSellerName span a");
    var mySellors=new Array();
    for(var i=0;i<rows.length;i++)
    {
        row = rows[i];
        mySellors.push(row.innerText);
    }
    return mySellors;  
}
casper.start(url, function(){
	fs.write("/hom/2.txt",tid);
    this.capture("/home/capture/"+pic);
    sellors = this.evaluate(getSellors);
    //sellors = sellors.join("|"); 
    sellors = JSON.stringify(sellors);
    console.log(sellors);
});
capture.then(function(){
    url = "http://localhost:8080/demo/pic?tid"+tid;
    this.open(url);
})
casper.then(function()
{
    url = "http://www.fbamate.net/amazon/Home/log/sellors";
    this.thenOpen(url,{
        method:"post",
        data:{
            'tid':tid,
            'sellors':sellors
        }
    },function(){
        this.echo(this.getHTML());
    })
}) 
casper.run();