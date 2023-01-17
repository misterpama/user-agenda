<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
    <form:form method="POST">
        <fieldset class="form-group">
        <label for="name">Name:</label>
        <input class="form-control" type="text" id="name" name="name">
        </fieldset>
        <fieldset class="form-group">
        <label for="surname">Surname:</label>
        <input class="form-control" type="text" id="surname" name="surname">
        </fieldset>
        <button class="btn btn-success" type="submit">SEARCH</button>
    </form:form>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th>Surname</th>
            <th>E-Mail</th>
            <th>Address</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${paramUsers}" var="user">
            <tr>
                <td>${user.name}</td>
                <td>${user.surname}</td>
                <td>${user.mail}</td>
                <td>${user.address}</td>
                <td><a class="btn btn-success" type="button"
                       href="/update-user?id=${user.id}">Update</a></td>
                <td><a class="btn btn-warning" type="button"
                       href="/delete-user?id=${user.id}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <form:form method="POST" enctype="multipart/form-data" action="upload">
        <fieldset class="form-group">
            <input class="form-control" type="file" name="file" />
        </fieldset>
        <button class="btn btn-success" type="submit">UPLOAD</button>
    </form:form>
    <div>
        <a class="button" href="/add-user">Add an user</a>
    </div>
</div>
<%@ include file="common/footer.jspf"%>