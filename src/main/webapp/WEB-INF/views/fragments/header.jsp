<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk" crossorigin="anonymous"></script>

</head>
<body class="fs-3  page-header">
    <nav class="navbar navbar-expand-lg bg-light">

        <ul class="nav text-uppercase ">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="projectList" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Project</a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/project/add">Add</a>
                    <a class="dropdown-item" href="/project/find">Manage</a>
                </div>
            </li>

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="clientList" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Client</a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/client/add">Add</a>
                    <a class="dropdown-item" href="/client/find">Manage</a>
                </div>

            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="departmentList" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Department</a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/department/add">Add</a>
                    <a class="dropdown-item" href="/department/find">Manage</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="productList" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Product</a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/product/add">Add</a>
                    <a class="dropdown-item" href="/product/find">Manage</a>
                </div>
            </li>

        </ul>

    </nav>


</body>
