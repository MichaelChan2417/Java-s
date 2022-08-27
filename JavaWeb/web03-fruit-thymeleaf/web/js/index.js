function delFruit(fid) {
    if (confirm('Confirm deletion?')) {
        window.location.href="del.do?fid="+fid;
    }
}