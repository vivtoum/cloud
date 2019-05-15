var pageUtil = {
    inti: function (elem, url, ajax_type, tbody_elem) {
        elem.bootstrapPaginator({
            currentPage: 1,
            totalPages: [[${files.total}]],
            size: "normal",
            bootstrapMajorVersion: 4,
            alignment: "right",
            numberOfPages: 5,
            itemTexts: function (type, page, current) {
                switch (type) {
                    case "first":
                        return "首页";
                    case "prev":
                        return "上一页";
                    case "next":
                        return "下一页";
                    case "last":
                        return "末页";
                    case "page":
                        return page;
                }//默认显示的是第一页。
            },
            onPageClicked: function (event, originalEvent, type, page) {//给每个页眉绑定一个事件，其实就是ajax请求，其中page变量为当前点击的页上的数字。
                $.ajax({
                    url: url,
                    type: ajax_type,
                    data: {'pageIndex': page * 1 - 1, 'pageSize': 20},
                    dataType: 'JSON',
                    success: function (data) {
                        debugger;
                        tbody_elem.empty();
                        var page_count = data.data.total;
                        var page_cont = data.data.html;
                        tbody_elem.append(page_cont);
                        $('#last_page').text(page_count)
                    }
                })
            }
        });
    }
}