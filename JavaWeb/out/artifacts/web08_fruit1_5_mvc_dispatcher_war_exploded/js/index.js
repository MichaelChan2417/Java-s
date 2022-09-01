function delFruit(fid) {
    if (confirm('Confirm deletion?')) {
        window.location.href="fruit.do?fid="+fid+"&operate=delete";
    }
}

function page(pageNo) {
    window.location.href="fruit.do?pageNo="+pageNo;
}