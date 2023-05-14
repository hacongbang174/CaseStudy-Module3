<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>HCB - contact us</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Favicon -->
    <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

    <!-- CSS
    ========================= -->


    <!-- Plugins CSS -->
    <link rel="stylesheet" href="assets/css/plugins.css">

    <!-- Main Style CSS -->
    <link rel="stylesheet" href="assets/css/style.css">

</head>

<body>

<!--Offcanvas menu area start-->
<div class="off_canvars_overlay"></div>
<jsp:include page="layout/menu.jsp"/>
<!--breadcrumbs area start-->
<div class="breadcrumbs_area other_bread">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <div class="breadcrumb_content">
                    <ul>
                        <li><a href="index.html">Trang chủ</a></li>
                        <li>/</li>
                        <li>Liên hệ</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<!--breadcrumbs area end-->


<!--contact area start-->
<div class="contact_area">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 col-md-12">
                <div class="contact_message content">
                    <h3>Liên hệ</h3>
                    <ul>
                        <li><i class="fa fa-fax"></i> Số nhà 28, đường Nguyễn Tri Phương , Thành phố Huế</li>
                        <li><i class="fa fa-phone"></i> <a
                                href="mailto:hacongbang174@gmail.com">hacongbang174@gmail.com</a></li>
                        <li><i class="fa fa-envelope-o"></i> (+84) 932555266</li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-6 col-md-12">
                <div class="contact_message form">
                    <h3>Gửi thông tin phản hồi</h3>
                    <form id="contact-form" method="GET"
                          action="https://script.google.com/macros/s/AKfycby2HoMCJyTeclcs-4VlInS-NG_hs161qiMTiuzUOpNZp_YRsmk/exec">
                        <p>
                            <label> Địa chỉ email</label>
                            <input name="Email" pattern="[^ @]*@[^ @]*" placeholder="Email *" required="" value=""
                                   type="email">
                        </p>
                        <p>
                            <label> Tiêu đề</label>
                            <input name="Subject" placeholder="Subject *" required="" value="" type="text">
                        </p>
                        <div class="contact_textarea">
                            <label> Thông tin</label>
                            <input placeholder="Message *" name="Message" required="" value="" class="form-control2">
                        </div>
                        <br>
                        <button type="submit"> Send</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!--contact area end-->

<!--contact map start-->
<div class="contact_map">
    <div class="container-fluid">
        <div class="row">
            <div class="col-12">
                <div class="map-area">
                    <iframe id="googleMap" style="border: none;"
                            src="https://www.google.com/maps/place/28+Nguy%E1%BB%85n+Tri+Ph%C6%B0%C6%A1ng,+Ph%C3%BA+H%E1%BB%99i,+Th%C3%A0nh+ph%E1%BB%91+Hu%E1%BA%BF,+Th%E1%BB%ABa+Thi%C3%AAn+Hu%E1%BA%BF,+Vi%E1%BB%87t+Nam/@16.4645685,107.5897655,17z/data=!3m1!4b1!4m6!3m5!1s0x3141a13c00686347:0x312e8ccbe67acf98!8m2!3d16.4645634!4d107.5923458!16s%2Fg%2F11f3sg03sy"></iframe>
                </div>
            </div>
        </div>
    </div>
</div>
<!--contact map end-->

<jsp:include page="layout/footer.jsp"/>

<!-- JS
============================================ -->

<!-- Plugins JS -->
<script src="assets/js/plugins.js"></script>

<!-- Main JS -->
<script src="assets/js/main.js"></script>
</body>

</html>