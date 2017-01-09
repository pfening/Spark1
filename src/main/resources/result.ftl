<html>
<head>
<title>ToDo!</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.1.0.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">

    <div class="navbar-header">
      <a class="navbar-brand" href="#">ToDo!</a>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="http://localhost:9090/todo">Link</a></li>
      </ul>

    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<br><br>
<div class="col-md-6">
<h1>ToDo list</h1>
<table class="table table-striped table-bordered">
    <thead>
        <tr>
            <th class="col-md-1">Task</th>
            <th class="col-md-1">Start Date</th>
            <th class="col-md-1">Due Date</th>
            <th class="col-md-1">Urgency</th>
            <th class="col-md-1">Finished</th>
        </tr>
    </thead>
    <tbody>
        <#list tasks as task>
          <tr>
              <td class="col-md-1">${task.task}
              <td class="col-md-1">${task.startdate}
              <td class="col-md-1">${task.duedate}
              <td class="col-md-1">${task.urgency}
              <td class="col-md-1">${task.finished}
        </#list>
    </tbody>
</table>
</div>

</body>
</html>