<%@page import="java.util.List"%>
<%@page import="com.ecommerce.model.Product"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="include/header.jsp"><c:param name="title" value="Demo Page"/></c:import>
    <div class="container mtb">
        <div class="row">
            <div class="col-lg-6">

                <h1>PRODUCT CATALOG</h1>
                <form method="get" action="ShoppingCartController?operation=shoppingcart">
                    <table border="1">
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Description</th>
                            <th>category</th>
                            <th>price</th>
                            <th>Options</th>  
                        </tr>

                    <c:forEach items= "${productsList}" var="productsList">

                        <tr>
                            <td>${productsList.id}</td>
                            <td>${productsList.name}</td>
                            <td>${productsList.description}</td>
                            <td>${productsList.category}</td>
                            <td>${productsList.price}</td>

                           
                            <td><a href="http://localhost:8080/ShoppingCartController?operation=addproduct&id=${productsList.id}">Update</a></td>
                        </tr>
                    </c:forEach>
            </form>
            </table>
                    <a href="http://localhost:8080/ShoppingCartController?operation=shoppingcart">shopping cart</a>
        </div>
    </div>
</div>
<c:import url="include/footer.jsp"></c:import>