<%--
  Created by IntelliJ IDEA.
  User: medve
  Date: 11.02.2018
  Time: 0:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="bootstrap/bootstrap.min.css" rel="stylesheet">
    <link href="bootstrap/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/demo.css" />
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <link rel="stylesheet" type="text/css" href="css/custom.css" />
    <script type="text/javascript" src="js/modernizr.custom.79639.js"></script>
    <noscript>
      <link rel="stylesheet" type="text/css" href="css/styleNoJS.css" />
    </noscript>
    <title>Company</title>
  </head>
  <body>
  <jsp:include page="navigation.jsp"/>


  <div class="container demo-2">

    <div id="slider" class="sl-slider-wrapper">

      <div class="sl-slider">

        <div class="sl-slide" data-orientation="horizontal" data-slice1-rotation="-25" data-slice2-rotation="-25" data-slice1-scale="2" data-slice2-scale="2">
          <div class="sl-slide-inner">
            <div class="bg-img bg-img-1"></div>
            <h2>A bene placito.</h2>
            <blockquote><p>You have just dined, and however scrupulously the slaughterhouse is concealed in the graceful distance of miles, there is complicity.</p><cite>Ralph Waldo Emerson</cite></blockquote>
          </div>
        </div>

        <div class="sl-slide" data-orientation="vertical" data-slice1-rotation="10" data-slice2-rotation="-15" data-slice1-scale="1.5" data-slice2-scale="1.5">
          <div class="sl-slide-inner">
            <div class="bg-img bg-img-2"></div>
            <h2>Regula aurea.</h2>
            <blockquote><p>Until he extends the circle of his compassion to all living things, man will not himself find peace.</p><cite>Albert Schweitzer</cite></blockquote>
          </div>
        </div>

        <div class="sl-slide" data-orientation="horizontal" data-slice1-rotation="3" data-slice2-rotation="3" data-slice1-scale="2" data-slice2-scale="1">
          <div class="sl-slide-inner">
            <div class="bg-img bg-img-3"></div>
            <h2>Dum spiro, spero.</h2>
            <blockquote><p>Thousands of people who say they 'love' animals sit down once or twice a day to enjoy the flesh of creatures who have been utterly deprived of everything that could make their lives worth living and who endured the awful suffering and the terror of the abattoirs.</p><cite>Dame Jane Morris Goodall</cite></blockquote>
          </div>
        </div>

        <div class="sl-slide" data-orientation="vertical" data-slice1-rotation="-5" data-slice2-rotation="25" data-slice1-scale="2" data-slice2-scale="1">
          <div class="sl-slide-inner">
            <div class="bg-img bg-img-4"></div>
            <h2>Donna nobis pacem.</h2>
            <blockquote><p>The human body has no more need for cows' milk than it does for dogs' milk, horses' milk, or giraffes' milk.</p><cite>Michael Klaper M.D.</cite></blockquote>
          </div>
        </div>

        <div class="sl-slide" data-orientation="horizontal" data-slice1-rotation="-5" data-slice2-rotation="10" data-slice1-scale="2" data-slice2-scale="1">
          <div class="sl-slide-inner">
            <div class="bg-img bg-img-5"></div>
            <h2>Acta Non Verba.</h2>
            <blockquote><p>I think if you want to eat more meat you should kill it yourself and eat it raw so that you are not blinded by the hypocrisy of having it processed for you.</p><cite>Margi Clarke</cite></blockquote>
          </div>
        </div>
      </div><!-- /sl-slider -->

      <nav id="nav-dots" class="nav-dots">
        <span class="nav-dot-current"></span>
        <span></span>
        <span></span>
        <span></span>
        <span></span>
      </nav>

    </div><!-- /slider-wrapper -->


  </div>
  <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
  <script type="text/javascript" src="js/jquery.ba-cond.min.js"></script>
  <script type="text/javascript" src="js/jquery.slitslider.js"></script>
  <script type="text/javascript">
      $(function() {

          var Page = (function() {

              var $nav = $( '#nav-dots > span' ),
                  slitslider = $( '#slider' ).slitslider( {
                      onBeforeChange : function( slide, pos ) {

                          $nav.removeClass( 'nav-dot-current' );
                          $nav.eq( pos ).addClass( 'nav-dot-current' );

                      }
                  } ),

                  init = function() {

                      initEvents();

                  },
                  initEvents = function() {

                      $nav.each( function( i ) {

                          $( this ).on( 'click', function( event ) {

                              var $dot = $( this );

                              if( !slitslider.isActive() ) {

                                  $nav.removeClass( 'nav-dot-current' );
                                  $dot.addClass( 'nav-dot-current' );

                              }

                              slitslider.jump( i + 1 );
                              return false;

                          } );

                      } );

                  };

              return { init : init };

          })();

          Page.init();

          /**
           * Notes:
           *
           * example how to add items:
           */

          /*

          var $items  = $('<div class="sl-slide sl-slide-color-2" data-orientation="horizontal" data-slice1-rotation="-5" data-slice2-rotation="10" data-slice1-scale="2" data-slice2-scale="1"><div class="sl-slide-inner bg-1"><div class="sl-deco" data-icon="t"></div><h2>some text</h2><blockquote><p>bla bla</p><cite>Margi Clarke</cite></blockquote></div></div>');

          // call the plugin's add method
          ss.add($items);

          */

      });
  </script>

  <div class="main-about__text">
    <h1>Строительная компания ХЕЛИКС ПЛЮС</h1>
    <p>&nbsp;</p>
    <p><strong>Helix Plus</strong>
      успешно решает амбициозные задачи на всех этапах строительства. Мы реализуем полный цикл строительных работ «под ключ» – от концепции и проектирования до запуска объекта в эксплуатацию.</p>
    <p>
    <p>Нас объединяет богатый профессиональный опыт и желание предложить рынку принципиально новый уровень строительных услуг, построенный на открытых расчетах и взаимном доверии. Поэтому мы ценим новые интересные идеи и готовы к решению трудных задач.</p>
    <p>&nbsp;</p>
    <p>Высокое качество исполнения
      <a href="//helix.by/proekty/">реализованных проектов</a> и <a href="//helix.by/klienty/">благодарные отзывы</a> счастливых клиентов позволяют утверждать, что строительные работы — наше призвание. А стремление постоянно развиваться, расширять свои навыки, получать новый опыт и улучшать этот мир помогает нам оставаться одними из лучших специалистов в своем деле.</p>
    <p>&nbsp;</p>
    <p>Наша компания старается всегда превосходить ожидания заказчика – будь то творческая концепция, масштабные строительно-монтажные работы или простая отделка помещений.</p>
    <p>&nbsp;</p>
    <p>Мы открыты для ваших идей.</p>
  </div>

  <div class="card-footer text-muted card text-white bg-primary" style = "margin-bottom: 0px;">
    <div class="card-body">
      <h4 class="card-title">© ООО «OURCOMPANY» 2018</h4>
      <br>
      <p class="card-text">blablabla</p>
    </div>
  </div>
  </body>
</html>
