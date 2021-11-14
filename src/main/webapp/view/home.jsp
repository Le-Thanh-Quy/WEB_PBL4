<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="Model.BEAN.Assess" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang Chủ</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Asset/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Asset/css/post.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Asset/css/footer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Asset/css/dialog.css">
    <script src="${pageContext.request.contextPath}/Asset/js/main.js"></script>
    <script src="${pageContext.request.contextPath}/Asset/js/xulyForm.js"></script>
    <script src="${pageContext.request.contextPath}/Asset/js/newpost.js"></script>
    <script src="${pageContext.request.contextPath}/Asset/js/xulylogin.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
</head>

<body>
<header id="menu">
    <div class="nav" id="nav">
        <img id="logo" src="${pageContext.request.contextPath}/Asset/img/white-logo.png" alt="">
        <ul>
            <li><a class="tab" id="active" href="index.jsp">Trang Chủ</a></li>
            <li><a class="tab" href="">Liên Hệ</a></li>
            <li><a
                    <c:if test="${logged == true}">
                        class="tab avatar_menu"
                        href = "${pageContext.request.contextPath}/account?others_user_name=null"
                        onmouseover="MenuOn()" onmouseleave="MenuOff()"
                    </c:if>
                    <c:if test="${logged == false}">
                        class="tab"
                        onclick="OpenLogin()"
                    </c:if>

            >${user}</a></li>
            <li>
                <a class="btnAdd" onmouseover="btnAddH()" onmouseleave="btnAddL()"
                        <c:if test="${logged == true}">
                            onclick="OpenPost()"
                        </c:if>
                        <c:if test="${logged == false}">
                            onclick="OpenLogin('newPost')"
                        </c:if>
                   onclick="newPost()"
                   style="color: black;"><i id="icon"></i> Tạo Tin</a>
            </li>
        </ul>
        <div class="menu_logout_H" id="menu_logout" onmouseover="MenuOn()" onmouseleave="MenuOff()">
            <div class="menu_model_H">
            </div>
            <div class="menu_info_H">
                <ul>
                    <a href="${pageContext.request.contextPath}/logout">
                        <li>Đăng Xuất</li>
                    </a>
                </ul>
            </div>
        </div>
    </div>
</header>

<div class="frameSearch">
    <div class="search-lable">
        <h5>Over 3+ Active Listings</h5>
        <h1>Tìm Kiếm Lịch Trình</h1>
    </div>
    <div class="search-input">

        <select id="selectTinhS" onchange="SelectStart();">

            <option selected>Điểm khởi hành</option>
            <c:forEach items="${Tinhs}" var="Tinh">
                <option value="${Tinh.matp}">${Tinh.name}</option>
            </c:forEach>
        </select>

        <select>
            <option selected>Thời gian khởi hành</option>
            <option value="00:00 - 02:00">00:00 - 02:00</option>
            <option value="01:00 - 03:00">01:00 - 03:00</option>
            <option value="02:00 - 04:00">02:00 - 04:00</option>
            <option value="03:00 - 05:00">03:00 - 05:00</option>
            <option value="04:00 - 06:00">04:00 - 06:00</option>
            <option value="05:00 - 07:00">05:00 - 07:00</option>
            <option value="06:00 - 08:00">06:00 - 08:00</option>
            <option value="07:00 - 09:00">07:00 - 09:00</option>
            <option value="08:00 - 10:00">08:00 - 10:00</option>
            <option value="09:00 - 11:00">09:00 - 11:00</option>
            <option value="10:00 - 12:00">10:00 - 12:00</option>
            <option value="11:00 - 13:00">11:00 - 13:00</option>
            <option value="12:00 - 14:00">12:00 - 14:00</option>
            <option value="13:00 - 15:00">13:00 - 15:00</option>
            <option value="14:00 - 16:00">14:00 - 16:00</option>
            <option value="15:00 - 17:00">15:00 - 17:00</option>
            <option value="16:00 - 18:00">16:00 - 18:00</option>
            <option value="17:00 - 19:00">17:00 - 19:00</option>
            <option value="18:00 - 20:00">18:00 - 20:00</option>
            <option value="19:00 - 21:00">19:00 - 21:00</option>
            <option value="20:00 - 22:00">20:00 - 22:00</option>
            <option value="21:00 - 23:00">21:00 - 23:00</option>
            <option value="22:00 - 00:00">22:00 - 00:00</option>
        </select>
        <select>
            <option selected>Ngày khởi hành</option>
            <option value="0">Hôm nay</option>
            <option value="1">Ngày mai</option>
            <option value="2">2 ngày tới</option>
            <option value="3">3 ngày tới</option>
            <option value="4">4 ngày tới</option>
            <option value="5">5 ngày tới</option>
        </select>

        <select id="selectTinhE" onchange="SelectEnd()">
            <option selected>Điểm đến</option>
            <c:forEach items="${Tinhs}" var="Tinh">
                <option value="${Tinh.matp}">${Tinh.name}</option>
            </c:forEach>
        </select>

        <button><i class="fas fa-search"></i></i>Search Now</button>
    </div>
</div>


<div class="framePost">
    <div class="title">
        <h1>Lịch trình mới nhất</h1>
    </div>
    <div class="list-post" id="list-post">
        <c:forEach items="${ListPost}" var="Post">
            <div class="post">
                <img class="post-img" src="${Post.getImage()}" alt="">

                <div class="post-main">
                    <c:if test="${logged == true}">
                        <a href="account?others_user_name=${Post.getUser().getAccountID()}" style="text-decoration: none">
                            <h1>${Post.getUser().getName()}</h1>
                        </a>
                    </c:if>

                    <c:if test="${logged == false}">
                        <h1 onclick="OpenLogin()">${Post.getUser().getName()}</h1>
                    </c:if>

                    <h5>${Post.getDateTime()}</h5>
                    <ul class="rate">

                        <c:forEach begin="1" end="${Post.getUser().getAssess().getRate()}" varStatus="loop">
                            <li><i class='fas fa-star'></i></li>
                        </c:forEach>
                        <c:forEach begin="${Post.getUser().getAssess().getRate()}" end="4" varStatus="loop">
                            <li><i class='far fa-star'></i></li>
                        </c:forEach>
                        <li>(${Post.getUser().getAssess().getReview()}) Lượt đánh giá</li>
                    </ul>

                    <div class="info">
                        <div class="start-info">
                            <h3>Điểm Xuất Phát</h3>
                            <ul class="address">
                                <li><i class="fas fa-map-marker-alt"></i> ${Post.getStartProvince()}</li>
                                <li><i class="fas fa-map-marker-alt"></i> ${Post.getStartDistrict()}</li>
                                <li><i class="fas fa-map-marker-alt"></i> ${Post.getStartCommune()}</li>
                            </ul>
                        </div>
                        <div class="time-info">
                            <h3>Thời gian: </h3>
                            <p><i class="far fa-clock"></i> ${Post.getTimeStart()}</p>
                            <p><i class="far fa-calendar-alt"></i> ${Post.getDate()}</p>
                        </div>
                        <div class="end-info">
                            <h3>Điểm Đến</h3>
                            <ul class="address">
                                <li><i class="fas fa-map-marker"></i> ${Post.getEndProvince()}</li>
                                <li><i class="fas fa-map-marker"></i> ${Post.getEndDistrict()}</li>
                                <li><i class="fas fa-map-marker"></i> ${Post.getEndCommune()}</li>
                            </ul>
                        </div>


                    </div>
                    <div class="status">
                        <p><i class="far fa-clipboard"></i> ${Post.getCaption()}</p>
                    </div>
                    <div class="post-button">
                        <a href=""><i class="far fa-comment"></i> Liên Hệ </a>
                        <a href=""><i class="far fa-comment-alt"></i> Bình Luận </a>
                        <a href=""><i class="fas fa-exclamation-triangle"></i> Báo Cáo</a>
                    </div>
                </div>
            </div>

        </c:forEach>
        <script>
            let ID = ${ListPost.get(ListPost.size() - 1).getID()};
        </script>

    </div>
</div>


<!-- load -->

<div class="formLoader" id="loadPost">
    <ul class="formLoading">
        <li></li>
        <li></li>
        <li></li>
    </ul>
</div>

<div class="footer">
    <footer>
        <div class="column">
            <img src="${pageContext.request.contextPath}/Asset/img/black-logo.png" alt="">
            <p>Nếu bạn cho rằng website Plot của chúng tôi hữu ích cho bạn, <br>Vui lòng hỗ trợ chúng tôi một chút
                qua BIDVBanking.</p>
        </div>
        <div class="column columnG">
            <h1>Chính sách</h1>
            <a href="">Bảo mật.</a>
            <a href="">Bản quyền</a>
            <br><br>
            <a href="">Nhận xét</a>
            <a href="">Về chúng tôi</a>
        </div>
        <div class="column">
            <p>
            <h1>Liên hệ chúng tôi</h1>
            54 Nguyễn Lương Bằng, Hoà Khánh Bắc, Liên Chiểu, Đà Nẵng<br><br>
            0384933379</p>
        </div>

    </footer>
    <div class="end-footer">
        <p>Bản quyền © 2021 bởi Plot. Đã đăng ký Bản quyền.
            <br>Cung cấp bởi: Quý, Trình , Hoàng
        </p>
    </div>
</div>

<!-- form -->


<div id="myModal" class="modal">
    <div class="modal-content">
        <div class="modal-header">
            <span class="close">&times;</span>
            <h3 id="nameTinh">Modal Header</h3>
        </div>
        <div class="modal-body">
            <select id="selectHuyen" onchange="SelectHuyen();">
                <option selected>Chọn Quận/Huyện</option>
            </select>
            <select id="selectXaClone">
                <option selected>Chọn Xã/Phường</option>
            </select>
            <select id="selectXa">
                <option selected>Chọn Xã/Phường</option>
            </select>
            <button onclick="SelectXa()">Đồng ý</button>
        </div>
    </div>
</div>

<div id="myModal-login" class="modal-login">
    <div class="modal-content-login">
        <span class="close" onclick="Close()">&times;</span>
        <div class="modal-body-login">
            <img src="${pageContext.request.contextPath}/Asset/img/black-logo.png" alt="">
            <form name="formLogin" action="login" method="get">
                <input id="user_txt" onblur="UserBlur()" type="text" name="user_txt" value=""
                       placeholder="User Name">
                <input id="pass_txt" onblur="PassBlur()" type="password" name="pass_txt" value=""
                       placeholder="Password">
                <span class="focus-border"><i></i></span>
                <input id="checkLoginForNewPost" type="hidden" name="checkNewPost" value="null">
                <i class="fas fa-eye" id="hide_show" onclick="HideShow()"></i>
            </form>
            <button onclick="checkLogin()">SIGN IN</button>
            <p>Don’t have an account?<a class="btnRegister" onclick="Signup()"> Sign Up</a></p>
        </div>
    </div>
</div>
<div id="myModal-signup" class="modal-signup">
    <div class="modal-content-signup">
        <span class="close" onclick="Close()">&times;</span>
        <div class="modal-body-signup">
            <img src="${pageContext.request.contextPath}/Asset/img/black-logo.png" alt="">
            <form name="formSignUp" action="${pageContext.request.contextPath}/register" method="get">
                <input id="user_txt_singup" onblur="SingUpUserBlur()" type="text" name="user_txt_singup" value=""
                       placeholder="User Name" maxlength="35">
                <input id="pass_txt_signup" onblur="SingUpPassBlur()" type="password" name="pass_txt_signup" value=""
                       placeholder="Password" maxlength="20">
                <i class="fas fa-eye" id="hide_show_signup" onclick="HideShowSignUp()"></i>
                <input id="pass_confirm_txt" onblur="ConfirmPassBlur()" type="password" name="pass_confirm_txt" value=""
                       placeholder="Confirm Password" maxlength="20">
                <i class="fas fa-eye" id="hide_showr" onclick="HideShowR()"></i>
            </form>
            <button onclick="checkSignUp()">SIGN UP</button>
            <p>If you have an account?Just<a class="btnRegister" onclick="Signup()"> Sign In</a></p>
        </div>
    </div>
</div>
<div id="myModal-newPost" class="modal-newPost" style="display: ${checkNewPost}">
    <div class="modal-content-newPost">
        <span class="close" onclick="ClosePost()">&times;</span>
        <div class="modal-body-newPost">
            <form name="form_newPost" action="newPost" method="get">
                <h3 class="title-newPost">Tạo bài viết</h3>
                <hr>
                <div class="avatar-newPost">
                    <img src="${user_info.getAvatar()}" alt="">
                    <h4>${user_info.getName()}</h4>
                    <input type="hidden" name="userID" value="${user_info.getID()}">
                    <p id="notification_newPost"><i class="fas fa-exclamation-circle"></i> Vui lòng nhập tên vào</p>
                </div>
                <div class="description-newPost">
                    <textarea name="caption_newPost" id="description_newPost" maxlength="65" cols="34" rows="4"
                              placeholder="Mô tả...."></textarea>
                    <div class="img-newPost">
                        <p><i class="fas fa-images" style="font-size: 25px;"></i> Thêm ảnh</p>
                        <img src="" alt="" id="out_img-newPost">
                        <input type="hidden" name="img_newPost"
                               value="https://drive.google.com/uc?export=view&id=1gSUXHvd-7VPnSFSb0JPJjVCuh8JwKy0m">
                        <input id="chooseIMGNewPost" type="file" accept="image/*" onchange="loadFile(event)">
                        <span class="close" id="closeIMG" onclick="CloseChooseIMG()">&times;</span>
                    </div>

                </div>

                <div class="start-newPost">
                    <label>Điểm khởi hành</label>
                    <select name="" id="newPostTinhS" onchange="selectTinhNewPost('0')">
                        <option selected>Tỉnh/Thành Phố</option>
                        <c:forEach items="${Tinhs}" var="Tinh">
                            <option value="${Tinh.matp}">${Tinh.name}</option>
                        </c:forEach>
                    </select>
                    <select name="" id="newPostHuyenS" onchange="selectHuyenNewPost('0')">
                        <option selected>Quận/Huyện</option>
                    </select>
                    <select name="start_newPost" id="newPostXaS">
                        <option selected>Xã/Phường</option>
                    </select>
                </div>
                <div class="start-newPost">
                    <label>Điểm đến</label>
                    <select name="" id="newPostTinhE" onchange="selectTinhNewPost('1')">
                        <option selected>Tỉnh/Thành Phố</option>
                        <c:forEach items="${Tinhs}" var="Tinh">
                            <option value="${Tinh.matp}">${Tinh.name}</option>
                        </c:forEach>
                    </select>
                    <select name="" id="newPostHuyenE" onchange="selectHuyenNewPost('1')">
                        <option selected>Quận/Huyện</option>
                    </select>
                    <select name="end_newPost" id="newPostXaE">
                        <option selected>Xã/Phường</option>
                    </select>
                </div>
                <div class="time-newPost">
                    <div class="date-newPost">
                        <label>Ngày khởi hành</label>
                        <input type="date" name="date_newPost"
                               value=<%=DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now())%>
                                       min="2021-01-01" max="2100-01-01" onchange="dateNewPostChange(event)">
                    </div>
                    <select name="time_newPost" id="time_newPost">
                        <option selected>Thời gian khởi hành</option>
                        <option value="00:00 - 02:00">00:00 - 02:00</option>
                        <option value="01:00 - 03:00">01:00 - 03:00</option>
                        <option value="02:00 - 04:00">02:00 - 04:00</option>
                        <option value="03:00 - 05:00">03:00 - 05:00</option>
                        <option value="04:00 - 06:00">04:00 - 06:00</option>
                        <option value="05:00 - 07:00">05:00 - 07:00</option>
                        <option value="06:00 - 08:00">06:00 - 08:00</option>
                        <option value="07:00 - 09:00">07:00 - 09:00</option>
                        <option value="08:00 - 10:00">08:00 - 10:00</option>
                        <option value="09:00 - 11:00">09:00 - 11:00</option>
                        <option value="10:00 - 12:00">10:00 - 12:00</option>
                        <option value="11:00 - 13:00">11:00 - 13:00</option>
                        <option value="12:00 - 14:00">12:00 - 14:00</option>
                        <option value="13:00 - 15:00">13:00 - 15:00</option>
                        <option value="14:00 - 16:00">14:00 - 16:00</option>
                        <option value="15:00 - 17:00">15:00 - 17:00</option>
                        <option value="16:00 - 18:00">16:00 - 18:00</option>
                        <option value="17:00 - 19:00">17:00 - 19:00</option>
                        <option value="18:00 - 20:00">18:00 - 20:00</option>
                        <option value="19:00 - 21:00">19:00 - 21:00</option>
                        <option value="20:00 - 22:00">20:00 - 22:00</option>
                        <option value="21:00 - 23:00">21:00 - 23:00</option>
                        <option value="22:00 - 00:00">22:00 - 00:00</option>
                    </select>


                </div>
            </form>
            <div class="time-newPost-submit">
                <button onclick="NewPost()">Đăng bài</button>
            </div>


        </div>
    </div>
</div>

<div class="notification" id="notificationForm">
    <p id="notification"></p>
</div>

<c:if test="${Mess != null}">
    <script !src="">
        function Mess() {
            var notification = document.getElementById("notification");

            var notificationForm = document.getElementById("notificationForm");
            notification.innerHTML = "${Mess}";
            notificationForm.style.display = "block";
            setTimeout(function () {
                notificationForm.style.display = "none";
            }, 4000);
        }

        Mess();
    </script>
</c:if>
</body>

</html>

