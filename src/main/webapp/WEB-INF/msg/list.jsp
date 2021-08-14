<%@include file="../includes/header.jsp"%>


    <!-- Experience-->
    <section class="resume-section" id="experience">
        <div class="resume-section-content">
            <h2 class="mb-5">ReceiveMsg</h2>
            <c:forEach items="${Receive}" var="dto">
            <div class="d-flex flex-column flex-md-row justify-content-between mb-5">
                <div class="flex-grow-1">
                    <h3 class="mb-0"><a href="/msg/read?mno=${dto.mno}">${dto.mno}</a> - ${dto.who}</h3>
                    <div class="subheading mb-3">Intelitec Solutions</div>
                    <p>${dto.content}</p>
                </div>
                <div class="flex-shrink-0"><span class="text-primary">${dto.regdate}</span></div>
            </div>
            </c:forEach>
            <h2 class="mb-5">SendMsg</h2>
            <c:forEach items="${Send}" var="dto">
                <div class="d-flex flex-column flex-md-row justify-content-between mb-5">
                    <div class="flex-grow-1">
                        <h3 class="mb-0">${dto.mno} - ${dto.who}</h3>
                        <div class="subheading mb-3">Intelitec Solutions</div>
                        <p>${dto.content}</p>
                    </div>
                    <div class="flex-shrink-0"><span class="text-primary">${dto.opendate}</span></div>
                </div>
            </c:forEach>
        </div>
    </section>

<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="/js/scripts.js"></script>
<%@include file="../includes/footer.jsp"%>