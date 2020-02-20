<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:import url="include/header.jsp"><c:param name="title" value="Demo Page"/></c:import>
    <div class="container mtb">
        <div class="row">
            <div class="col-lg-6">
                <form method="post" action="UserController">
                    <h3>Login</h3><br/>
                    Email: <input type="email" name="email" placeholder="Enter email"/><br/><br/>
                    Password: <input type="password" name="password" placeholder="Enter password"/><br/><br/>
                    <input type="submit" name="operation" value="login"/>
                </form>
                <br/>
                <a href="register.jsp">Create account</a>
            </div>
        </div>
    </div>
<c:import url="include/footer.jsp"></c:import>