<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Danh sách nhân viên | Quản trị Admin</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Main CSS-->
    <link rel="stylesheet" type="text/css" href="admin/css/main.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
    <!-- or -->
    <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">

    <!-- Font-icon css-->
    <link rel="stylesheet" type="text/css"
          href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
          integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>

    <!-- Graphic Revenue -->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Tailwind Admin Starter Template : Tailwind Toolbox</title>
    <meta name="description" content="Tailwind CSS Starter template - Admin theme, dashboard, or web application UI!">
    <meta name="keywords"
          content="tailwind,tailwindcss,tailwind css,css,starter template,free template,fixed header, admin starter template, admin template, admin console, example">

    <link href="/admin/Toolbox_files/css" rel="stylesheet">
    <link rel="apple-touch-icon" sizes="180x180" href="https://www.tailwindtoolbox.com/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="https://www.tailwindtoolbox.com/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="https://www.tailwindtoolbox.com/favicon-16x16.png">
    <link rel="manifest" href="https://www.tailwindtoolbox.com/site.webmanifest">
    <link rel="mask-icon" href="https://www.tailwindtoolbox.com/safari-pinned-tab.svg" color="#5bbad5">
    <meta name="msapplication-TileColor" content="#00aba9">
    <meta name="theme-color" content="#3b7977">

    <!-- Primary Meta Tags -->
    <title>Tailwind Toolbox - Free Starter Templates and Components for Tailwind CSS</title>
    <meta name="title" content="Tailwind Toolbox - Free Starter Templates and Components for Tailwind CSS">
    <meta name="description"
          content="Free open source Tailwind CSS starter Templates and Components to get you started quickly to creating websites in Tailwind CSS!">

    <!-- Open Graph / Facebook -->
    <meta property="og:type" content="website">
    <meta property="og:url" content="https://www.tailwindtoolbox.com/">
    <meta property="og:title" content="Tailwind Toolbox - Free Starter Templates and Components for Tailwind CSS">
    <meta property="og:description"
          content="Free open source Tailwind CSS starter Templates and Components to get you started quickly to creating websites in Tailwind CSS!">
    <meta property="og:image" content="https://www.tailwindtoolbox.com/social.png">

    <!-- Twitter -->
    <meta property="twitter:card" content="summary_large_image">
    <meta property="twitter:url" content="https://www.tailwindtoolbox.com/">
    <meta property="twitter:title" content="Tailwind Toolbox - Free Starter Templates and Components for Tailwind CSS">
    <meta property="twitter:description"
          content="Free open source Tailwind CSS starter Templates and Components to get you started quickly to creating websites in Tailwind CSS!">
    <meta property="twitter:image" content="https://www.tailwindtoolbox.com/social.png">


    <link rel="stylesheet" href="/admin/Toolbox_files/all.css"
          integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <link href="https://unpkg.com/tailwindcss@2.2.19/dist/tailwind.min.css" rel=" stylesheet">
    <!--Replace with your tailwind.css once created-->
    <link href="/admin/Toolbox_files/emoji.css" rel="stylesheet">
    <!--Totally optional :) -->
    <script src="/admin/Toolbox_files/Chart.bundle.min.js.tải xuống"
            integrity="sha256-XF29CBwU1MWLaGEnsELogU6Y6rcc5nCkhhx89nFMIDQ=" crossorigin="anonymous"></script>
    <style type="text/css">
        /* Chart.js */
        @-webkit-keyframes chartjs-render-animation {
            from {
                opacity: 0.99
            }

            to {
                opacity: 1
            }
        }

        @keyframes chartjs-render-animation {
            from {
                opacity: 0.99
            }

            to {
                opacity: 1
            }
        }

        .chartjs-render-monitor {
            -webkit-animation: chartjs-render-animation 0.001s;
            animation: chartjs-render-animation 0.001s;
        }
    </style>

    <script id="_carbonads_projs" type="text/javascript" src="./Toolbox_files/CK7D52JJ.json"></script>
    <style>
        @keyframes blinkWarning {
            0% {
                color: red;
            }

            100% {
                color: white;
            }
        }

        @-webkit-keyframes blinkWarning {
            0% {
                color: red;
            }

            100% {
                color: white;
            }
        }
    </style>
</head>

<body onload="time()" class="app sidebar-mini rtl">
<!-- Navbar-->
<header class="app-header">
    <!-- Sidebar toggle button--><a class="app-sidebar__toggle" href="#" data-toggle="sidebar"
                                    aria-label="Hide Sidebar"></a>
    <!-- Navbar Right Menu-->
    <ul class="app-nav">


        <!-- User Menu-->
        <li><a class="app-nav__item" href="dashboard"><i class='bx bx-log-out bx-rotate-180'></i> </a>

        </li>
    </ul>
</header>
<!-- Sidebar menu-->
<div class="app-sidebar__overlay" data-toggle="sidebar"></div>
<aside class="app-sidebar">
    <div class="app-sidebar__user"><img class="app-sidebar__user-avatar" src="admin/images/user.png" width="50px"
                                        alt="User Image">
        <div>
            <p class="app-sidebar__user-name"><b>${sessionScope.user.user_name}</b></p>
            <p class="app-sidebar__user-designation">Chào mừng bạn trở lại</p>
        </div>
    </div>
    <hr>
    <ul class="app-menu">
        <li><a class="app-menu__item" href="dashboard"><i class='app-menu__icon bx bx-tachometer'></i><span
                class="app-menu__label">Bảng điều khiển</span></a></li>
        <li><a class="app-menu__item" href="customerManager"><i class='app-menu__icon bx bx-user-voice'></i><span
                class="app-menu__label">Quản lý khách hàng</span></a></li>
        <li><a class="app-menu__item" href="productManager"><i
                class='app-menu__icon bx bx-purchase-tag-alt'></i><span class="app-menu__label">Quản lý sản phẩm</span></a>
        </li>
        <li><a class="app-menu__item" href="orderManager"><i class='app-menu__icon bx bx-task'></i><span
                class="app-menu__label">Quản lý đơn hàng</span></a></li>
        <li><a class="app-menu__item" href="revenueManager"><i class='app-menu__icon fa-solid fa-sack-dollar'></i><span
                class="app-menu__label">Quản lý doanh thu</span></a></li>
        <li><a class="app-menu__item"
               href="https://docs.google.com/spreadsheets/d/1elWy0LYj9ngbmywMGwy8Noe_K7WmyisQ6aHOK6RnXZI"
               target="_blank"><i class='app-menu__icon bx bx-task'></i><span
                class="app-menu__label">Kiểm tra phản hồi</span></a></li>
    </ul>
</aside>
<main class="app-content">
    <div class="app-title">
        <ul class="app-breadcrumb breadcrumb side">
            <li class="breadcrumb-item active"><a href="#"><b>Biểu đồ doanh thu</b></a></li>
        </ul>
        <div id="clock"></div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <div class="tile">
                <div class="tile-body">

                    <div class="row element-button">
                        <div class="col-sm-2">
                            <a class="btn btn-delete btn-sm print-file" type="button" title="In"
                               onclick="myApp.printTable()"><i
                                    class="fas fa-print"></i> In dữ liệu</a>
                        </div>
                    </div>
                    <div class="shop_toolbar_wrapper" style="border:none">
                        <div class="dropdown ">
                            <button style="color: #000; background-color: black;border:none; font-family: sans-serif;"
                                    class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Bộ lọc
                            </button>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                <a class="dropdown-item" href="/revenueManager?action=revenueByMonth&type=month">Doanh
                                    thu theo tháng</a>
                                <%--                                <a class="dropdown-item" href="/revenueManager?action=revenueByYear&type=year">Doanh thu theo năm</a>--%>
                            </div>
                        </div>
                    </div>
                    <!--Graph Card-->
                    <div class="bg-white border-transparent rounded-lg shadow-xl">
                        <div
                                class="bg-gradient-to-b from-gray-300 to-gray-100 uppercase text-gray-800 border-b-2 border-gray-300 rounded-tl-lg rounded-tr-lg p-2">
                            <h5 class="font-bold uppercase text-gray-600">Graph</h5>
                        </div>
                        <div class="p-5">
                            <div class="chartjs-size-monitor"
                                 style="position: absolute; inset: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;">
                                <div class="chartjs-size-monitor-expand"
                                     style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;">
                                    <div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div>
                                </div>
                                <div class="chartjs-size-monitor-shrink"
                                     style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;">
                                    <div style="position:absolute;width:200%;height:200%;left:0; top:0"></div>
                                </div>
                            </div>
                            <canvas id="chartjs-1" class="chartjs chartjs-render-monitor" width="465" height="231"
                                    style="display: block; height: 208px; width: 417px;"></canvas>
                            <script>
                                new Chart(document.getElementById("chartjs-1"), {
                                    "type": "bar",
                                    "data": {
                                        "labels": ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"],
                                        "datasets": [{
                                            "label": "Revenue: " + ${total},
                                            "data": [${bill1}, ${bill2}, ${bill3}, ${bill4}, ${bill5}, ${bill6}, ${bill7}, ${bill8}, ${bill9}, ${bill10}, ${bill11}, ${bill12}],
                                            "fill": false,
                                            "backgroundColor": ["rgba(255, 99, 132, 0.2)", "rgba(255, 159, 64, 0.2)", "rgba(255, 205, 86, 0.2)", "rgba(75, 192, 192, 0.2)", "rgba(54, 162, 235, 0.2)", "rgba(153, 102, 255, 0.2)", "rgba(201, 203, 207, 0.2)"],
                                            "borderColor": ["rgb(255, 99, 132)", "rgb(255, 159, 64)", "rgb(255, 205, 86)", "rgb(75, 192, 192)", "rgb(54, 162, 235)", "rgb(153, 102, 255)", "rgb(201, 203, 207)"],
                                            "borderWidth": 1
                                        }]
                                    },
                                    "options": {
                                        "scales": {
                                            "yAxes": [{
                                                "ticks": {
                                                    "beginAtZero": true
                                                }
                                            }]
                                        }
                                    }
                                });
                            </script>
                        </div>
                    </div>
                    <!--/Graph Card-->
                </div>
            </div>
        </div>
    </div>
</main>
<c:forEach items="${requestScope.user}" var="u">
    <div class="modal fade" id="ModalUP${u.getUser_id()}" tabindex="-1" role="dialog" aria-hidden="true"
         data-backdrop="static"
         data-keyboard="false">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                    <%--                        <form method="POST" action="customerManager?action=update">--%>
                    <%--                            <div class="modal-body">--%>
                    <%--                                <div class="row">--%>
                    <%--                                    <div class="form-group  col-md-12">--%>
                    <%--                                        <span class="thong-tin-thanh-toan">--%>
                    <%--                                            <h5>Thêm Làm quản trị viên</h5>--%>
                    <%--                                        </span>--%>
                    <%--                                    </div>--%>
                    <%--                                </div>--%>
                    <%--                                <div class="row">--%>
                    <%--                                    <div class="form-group col-md-6">--%>
                    <%--                                        <label for="exampleSelect1" class="control-label">Quyền quản trị</label>--%>
                    <%--                                        <input hidden name="user_id" value="${u.user_id}">--%>
                    <%--                                        <select name="permission" class="form-control" id="exampleSelect1">--%>
                    <%--                                            <option value="True">Cho phép</option>--%>
                    <%--                                            <option value="False">Hủy bỏ</option>--%>
                    <%--                                        </select>--%>
                    <%--                                    </div>--%>
                    <%--                                </div>--%>
                    <%--                                <BR>--%>
                    <%--                                <button class="btn btn-save" type="submit">Lưu lại</button>--%>
                    <%--                                <a class="btn btn-cancel" data-dismiss="modal" href="#">Hủy bỏ</a>--%>
                    <%--                                <BR>--%>
                    <%--                            </div>--%>
                    <%--                        </form>--%>
                <div class="modal-footer">
                </div>
            </div>
        </div>
    </div>
</c:forEach>
<!-- Essential javascripts for application to work-->
<script src="admin/js/jquery-3.2.1.min.js"></script>
<script src="admin/js/popper.min.js"></script>
<script src="admin/js/bootstrap.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="admin/js/main.js"></script>
<!-- The javascript plugin to display page loading on top-->
<script src="admin/js/plugins/pace.min.js"></script>
<!-- Page specific javascripts-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
<!-- Data table plugin-->
<script type="text/javascript" src="admin/js/plugins/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="admin/js/plugins/dataTables.bootstrap.min.js"></script>
<script type="text/javascript">$('#sampleTable').DataTable();</script>
<script>
    function deleteRow(r) {
        var i = r.parentNode.parentNode.rowIndex;
        document.getElementById("myTable").deleteRow(i);
    }

    jQuery(function () {
        jQuery(".trash").click(function () {
            swal({
                title: "Cảnh báo",

                text: "Bạn có chắc chắn là muốn xóa nhân viên này?",
                buttons: ["Hủy bỏ", "Đồng ý"],
            })
                .then((willDelete) => {
                    if (willDelete) {
                        swal("Đã xóa thành công.!", {});
                    }
                });
        });
    });

    //Thời Gian
    function time() {
        var today = new Date();
        var weekday = new Array(7);
        weekday[0] = "Chủ Nhật";
        weekday[1] = "Thứ Hai";
        weekday[2] = "Thứ Ba";
        weekday[3] = "Thứ Tư";
        weekday[4] = "Thứ Năm";
        weekday[5] = "Thứ Sáu";
        weekday[6] = "Thứ Bảy";
        var day = weekday[today.getDay()];
        var dd = today.getDate();
        var mm = today.getMonth() + 1;
        var yyyy = today.getFullYear();
        var h = today.getHours();
        var m = today.getMinutes();
        var s = today.getSeconds();
        m = checkTime(m);
        s = checkTime(s);
        nowTime = h + " giờ " + m + " phút " + s + " giây";
        if (dd < 10) {
            dd = '0' + dd
        }
        if (mm < 10) {
            mm = '0' + mm
        }
        today = day + ', ' + dd + '/' + mm + '/' + yyyy;
        tmp = '<span class="date"> ' + today + ' - ' + nowTime +
            '</span>';
        document.getElementById("clock").innerHTML = tmp;
        clocktime = setTimeout("time()", "1000", "Javascript");

        function checkTime(i) {
            if (i < 10) {
                i = "0" + i;
            }
            return i;
        }
    }

    //In dữ liệu
    var myApp = new function () {
        this.printTable = function () {
            var tab = document.getElementById('sampleTable');
            var win = window.open('', '', 'height=700,width=700');
            win.document.write(tab.outerHTML);
            win.document.close();
            win.print();
        }
    }

</script>
<script>
    /*Toggle dropdown list*/
    function toggleDD(myDropMenu) {
        document.getElementById(myDropMenu).classList.toggle("invisible");
    }

    /*Filter dropdown options*/
    function filterDD(myDropMenu, myDropMenuSearch) {
        var input, filter, ul, li, a, i;
        input = document.getElementById(myDropMenuSearch);
        filter = input.value.toUpperCase();
        div = document.getElementById(myDropMenu);
        a = div.getElementsByTagName("a");
        for (i = 0; i < a.length; i++) {
            if (a[i].innerHTML.toUpperCase().indexOf(filter) > -1) {
                a[i].style.display = "";
            } else {
                a[i].style.display = "none";
            }
        }
    }

    // Close the dropdown menu if the user clicks outside of it
    window.onclick = function (event) {
        if (!event.target.matches('.drop-button') && !event.target.matches('.drop-search')) {
            var dropdowns = document.getElementsByClassName("dropdownlist");
            for (var i = 0; i < dropdowns.length; i++) {
                var openDropdown = dropdowns[i];
                if (!openDropdown.classList.contains('invisible')) {
                    openDropdown.classList.add('invisible');
                }
            }
        }
    }
</script>
</body>

</html>

