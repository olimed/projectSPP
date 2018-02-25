<%--
  Created by IntelliJ IDEA.
  User: medve
  Date: 16.02.2018
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="bootstrap/bootstrap.min.css" rel="stylesheet">
    <link href="bootstrap/bootstrap.css" rel="stylesheet">
    <title>Contacts</title>
</head>
<body>
    <jsp:include page="navigation.jsp"/>
    <div class="container" style="margin-top: 120px; margin-bottom: 30px;">
        <h1 class="text-center" style="align-content: center;">CONTACTS</h1>
        <div class="row" style="margin-right: 0px; margin-left: 0px; margin-top: 30px;">
            <div class="col-sm-5">
                <p>Contact us and we'll get back to you within 24 hours.</p>
                <p><span class="glyphicon glyphicon-map-marker"></span> 220116, Minsk, Dzerzinskogo avenue, 95</p>
                <p><span class="glyphicon glyphicon-phone"></span> +375 29 15151515</p>
                <p><span class="glyphicon glyphicon-envelope"></span> myemail@something.com</p>
            </div>
            <div class="col-sm-7 slideanim">
                <div class="row">
                    <div class="col-sm-6 form-group">
                        <input class="form-control" id="name" name="name" placeholder="Name" type="text" required>
                    </div>
                    <div class="col-sm-6 form-group">
                        <input class="form-control" id="email" name="email" placeholder="Email" type="email" required>
                    </div>
                </div>
                <textarea class="form-control" id="comments" name="comments" placeholder="Comment" rows="5"></textarea><br>
                <div class="row">
                    <div class="col-sm-12 form-group">
                        <button type="button" class="btn btn-danger pull-right" type="submit">Send</button>
                    </div>
                </div>
            </div>

        </div>
    </div>

    <div id="googleMap" style="height:400px;width:100%;"></div>
    <script>
        function myMap() {
            var myCenter = new google.maps.LatLng(53.858184, 27.485138);
            var mapProp = {center:myCenter, zoom:12, scrollwheel:false, draggable:false, mapTypeId:google.maps.MapTypeId.ROADMAP};
            var map = new google.maps.Map(document.getElementById("googleMap"),mapProp);
            var marker = new google.maps.Marker({position:myCenter});
            marker.setMap(map);
        }
    </script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAFUUpJ5sRdoAPnJNKGvuW-HU4milanF-A&callback=myMap"></script>

    <div class="card-footer text-muted" style="padding-top: 60px;">
        <h4 class="card-title">© ООО «OURCOMPANY» 2018</h4>
        <br>
        <p class="card-text">blablabla</p>
    </div>
</body>
</html>
