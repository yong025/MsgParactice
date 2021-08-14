<%--
  Created by IntelliJ IDEA.
  User: stell
  Date: 2021-08-12
  Time: 오후 3:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../includes/header.jsp"%>

<!-- Experience-->
<section class="resume-section" id="experience">
    <div class="resume-section-content">
        <h2 class="mb-5">Experience</h2>
        <form action="/msg/register" method="post">
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon1">WHO</span>
                </div>
                <input type="text" name="who" readonly value="${member.mid}" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
            </div>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon2">WHOM</span>
                </div>
                <input type="text" name="whom" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
            </div>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon3">CONTENT</span>
                </div>
                <input type="textarea" name="content" class="form-control" placeholder="messge" aria-label="Username" aria-describedby="basic-addon1">
            </div>
            <div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </form>
    </div>
</section>

<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="/js/scripts.js"></script>
<%@include file="../includes/footer.jsp"%>
