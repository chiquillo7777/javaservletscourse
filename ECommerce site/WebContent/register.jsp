<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:import url="include/header.jsp"><c:param name="title" value="Demo Page"/></c:import>
    <div class="container mtb">
        <div class="row">
            <div class="col-lg-6">
                <h1>Hello World!</h1>

                <form method="post" action="UserController">
                    <h3>Register Page</h3>
                    Name: <input type="text" name="username" placeholder="Enter name"/><br/><br/>
                    Email: <input type="email" name="email" placeholder="Enter email"/><br/><br/>
                    Password: <input type="password" name="password" placeholder="Enter password"/><br/><br/>
                    <input type="submit" name="operation" value="register"/>
                </form>
            </div>
        </div>
    </div>
<c:import url="include/footer.jsp"></c:import>