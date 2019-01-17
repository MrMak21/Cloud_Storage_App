<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">


    <title>Signin Team 4</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <!-- Custom styles for this template -->
    <link href="/signin.css" rel="stylesheet">
</head>

<body class="text-center">
<div class="container">
    <h1>Mak Cloud</h1>
    <form action="/signUp" name="signUpForm" method="POST" class="form-signin">
        <!-- <img class="mb-4" src="../../assets/brand/bootstrap-solid.svg" alt="" width="72" height="72"> -->
        <h1 class="h3 mb-3 font-weight-normal">Sign Up</h1>

        <label for="firstname" class="sr-only">Firstname</label>
        <input name="firstname" type="text" id="firstname" class="form-control" placeholder="Firstname" required autofocus>

        <label for="lastname" class="sr-only">Lastname</label>
        <input name="lastname" type="text" id="lastname" class="form-control" placeholder="Lastname" required autofocus>

        <label for="email" class="sr-only">Email</label>
        <input name="email" type="text" id="email" class="form-control" placeholder="Email" required autofocus>

        <label for="inputPassword" class="sr-only">Password</label>
        <input name ="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>

        <input class="form-check-input" type="hidden" name="type" id="admin" value="User">


        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign Up</button>
        <p class="mt-5 mb-3 text-muted">&copy; 2019-2020</p>
    </form>
    <a class="nav-link btn btn-outline-light" href="/logout">Sign out</a>
</div>
</body>
</html>
