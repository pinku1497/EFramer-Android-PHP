<?php
	
	include('fmconfig.php');
	
	/*echo "<pre>";
	print_r($_POST);
	echo "</pre>";*/
	
	$package_id = "";
	$packagename = "";
	$duration = "";
	$rate = "";
	$description = "";
	
	if( (isset($_POST)) && (!empty($_POST)) )
	{
		$package_id = $_POST['package_id'];
		$packagename = $_POST['packagename'];
		$duration = $_POST['duration'];
		$rate = $_POST['rate'];
		$description = $_POST['description'];
	}
	
	if( (isset($_POST['frm_package_submit'])) && (!empty($_POST['frm_package_submit'])) )
	{
	$sql="update package SET packagename='$packagename',duration='$duration',rate='$rate',description='$description' ";
	$where = "where package_id='$package_id'";
	
	$query = $sql.$where;
	
			$result = mysqli_query($conn,$query);
			if($result==true)
			{
				echo "Done";
			}
			else
			{
				echo "Fail";
			}


		mysqli_close($conn);
		
	}	
	
	
	
	
?>
<div class="row">
        <div class="col-md-12">
          <div class="tile">
            <div class="row">
  <div class="col-lg-6">
<form name="frm_package_" action="updatepackage.php" method="post">
			<div class="form-group">
                    <label for="exampleInputPassword1">PacakageId</label>
                    <input class="form-control" id="name" type="text"value="<?php echo $package_id;?>" />
                  </div>
				  <div class="form-group">
                    <label for="exampleInputPassword1">PackageName</label>
                    <input class="form-control" id="name" type="text"value="<?php echo $packagename;?>" />
                  </div>
		     <div class="form-group">
                    <label for="exampleInputPassword1">Duration</label>
                    <input class="form-control" id="name" type="text"value="<?php echo $duration;?>" />
                  </div>
		  <div class="form-group">
                    <label for="exampleInputPassword1">Rate</label>
                    <input class="form-control" id="name" type="text"value="<?php echo $rate;?>" />
                  </div>
			 <div class="form-group">
                    <label for="exampleInputPassword1">Description</label>
                    <input class="form-control" id="name" type="text"value="<?php echo $description;?>" />
                  </div>
			
			<input type="submit" class="btn btn-info" name="frm_package_submit"value="Update" />
 </form>
</div>
</div>
</div>
</div>
</div>


