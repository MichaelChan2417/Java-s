function delFruit(fid) {
    if (confirm('Confirm deletion?')) {
        window.location.href="del.do?fid="+fid;
    }
}

function page(pageNo) {
    window.location.href="index?pageNo="+pageNo;
}