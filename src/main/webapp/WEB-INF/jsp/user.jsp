<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
    <form:form method="POST" modelAttribute="user">
        <form:hidden path="id" />
        <fieldset class="form-group">
            <form:label path="name">Name</form:label>
            <form:input class="form-control" type="text" path="name"
                        required="required" />
            <form:errors path="name" cssClass="text-warning" />
        </fieldset>
        <fieldset class="form-group">
            <form:label path="surname">Surname</form:label>
            <form:input class="form-control" type="text" path="surname"
                        required="required" />
            <form:errors path="surname" cssClass="text-warning" />
        </fieldset>
        <fieldset class="form-group">
            <form:label path="mail">Mail</form:label>
            <form:input class="form-control" type="text" path="mail"
                        required="required" />
            <form:errors path="mail" cssClass="text-warning" />
        </fieldset>
        <fieldset class="form-group">
            <form:label path="address">Address</form:label>
            <form:input class="form-control" type="text" path="address"
                        required="required" />
            <form:errors path="address" cssClass="text-warning" />
        </fieldset>
        <button class="btn btn-success" type="submit">SUBMIT</button>
    </form:form>
</div>
<%@ include file="common/footer.jspf"%>