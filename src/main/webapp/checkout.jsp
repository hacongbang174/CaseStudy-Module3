<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html class="no-js" lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>HCB - checkout page</title>
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
        <script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/11.7.5/sweetalert2.all.min.js" integrity="sha512-2JsZvEefv9GpLmJNnSW3w/hYlXEdvCCfDc+Rv7ExMFHV9JNlJ2jaM+uVVlCI1MAQMkUG8K83LhsHYx1Fr2+MuA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    </head>

    <body>

        <!-- Main Wrapper Start -->
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
                                <li><a href="index.html">home</a></li>
                                <li>/</li>
                                <li>checkout</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--breadcrumbs area end-->

        <!--Checkout page section-->

        <div class="Checkout_section" id="accordion">
            <div class="container">
                <div class="checkout_form">

                    <form action="/checkout?action=payment" method="POST">
                        <div class="row">
                            <div class="col-lg-5 col-md-5">
                                <h3>Chi tiết đơn hàng</h3>
                                <div class="row">

                                    <div class="col-lg-12 mb-20">
                                        <label>Tên khách hàng<span>*</span></label>
                                        <input readonly="" value="${sessionScope.user.getUser_name()}" type="text">
                                    </div>
                                    <div class="col-lg-12 mb-20">
                                        <label> Email <span>*</span></label>
                                        <input readonly="" value="${sessionScope.user.getUser_email()}" type="text">
                                    </div>
                                    <div class="col-lg-12 mb-20">
                                        <label>Địa chỉ<span>*</span></label>
                                        <input required name="address" type="text" value="">
                                    </div>
                                    <div class="col-lg-12 mb-20">
                                        <label>Số điện thoại<span>*</span></label>
                                        <input required name="phone" type="number" value="">
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-7 col-md-7">

                                <h3>Sản phẩm</h3>
                                <div class="order_table table-responsive">
                                    <table>
                                        <thead>
                                            <tr>
                                                <th>Product</th>
                                                <th>Size</th>
                                                <th>Color</th>
                                                <th>Total</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:set var="o" value="${sessionScope.cart}"/>
                                            <c:forEach items="${o.items}" var="i">
                                                <tr>
                                                    <td> ${i.product.getProduct_name()} <strong> × ${i.getQuantity()}</strong></td>
                                                    <td> ${i.getSize()}</td>
                                                    <td> ${i.getColor()}</td>
                                                    <td> ${i.product.getProductPrice(i.product.getProduct_price() * i.getQuantity())}</td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                        <c:if test="${sessionScope.cart!=null}">
                                            <tfoot>
                                                <tr>
                                                    <th>Tổng giá</th>
                                                    <td>${sessionScope.cart.getBillDetailPrice(sessionScope.total)}</td>
                                                </tr>
                                                <tr>
                                                    <th>Phí ship</th>
                                                    <td><strong>${sessionScope.cart.getBillDetailPrice(sessionScope.surcharge)}</strong></td>
                                                </tr>
                                                <tr class="order_total">
                                                    <th>Tổng đơn</th>
                                                    <td><strong>${sessionScope.cart.getBillDetailPrice(sessionScope.total + sessionScope.surcharge)}</strong></td>
                                                </tr>
                                            </tfoot>
                                        </c:if>
                                    </table>
                                </div>
                                <div class="payment_method">
                                    <div class="panel-default">
                                        <input id="payment_defult" value="momo" name="payment_method" type="radio"
                                               data-target="createp_account" />
                                        <label for="payment_defult" data-toggle="collapse" data-target="#collapsedefult"
                                               aria-controls="collapsedefult">Momo <img src="assets/img/icon/papyel.png"
                                                                                 alt=""></label>
                                    </div>
                                    <div class="panel-default">
                                        <input id="payment_defult" value="cod" name="payment_method" type="radio"
                                               data-target="createp_account" />
                                        <label for="payment_defult" data-toggle="collapse" data-target="#collapsedefult"
                                               aria-controls="collapsedefult">Thanh toán khi nhận hàng <img src="assets/img/icon/papyel.png"
                                                                                                     alt=""></label>
                                    </div>
                                    <p style="color: red; align-content: center;">
                                        ${requestScope.error_payment}
                                    </p>
                                    <div class="order_button">
                                        <button type="submit">Đặt hàng</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!--Checkout page section end-->
        <!--footer area start-->
        <jsp:include page="layout/footer.jsp"/>
        <!--footer area end-->

        <!-- JS
============================================ -->
        <c:if test="${requestScope.message !=null}">
            <script>
                window.onload = function () {
                    Swal.fire({
                        position: 'top-end',
                        icon: 'success',
                        title: 'Đặt hàng thành công!',
                        showConfirmButton: false,
                        timer: 1500
                    })
                };
            </script>
        </c:if>
        <!-- Plugins JS -->
        <script src="assets/js/plugins.js"></script>

        <!-- Main JS -->
        <script src="assets/js/main.js"></script>
    </body>

</html>
