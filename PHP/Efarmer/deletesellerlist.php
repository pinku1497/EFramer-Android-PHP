<?php
	
	include('fmconfig.php');
	
	$sr_id = "";
	if( (isset($_GET['sr_id'])))
	{
		$sr_id =$_GET['sr_id'];
	$sql="DELETE FROM sellerreg  WHERE sr_id='".$sr_id."' ";
	$result = mysqli_query($conn,$sql);
	
			if($result==true)
			{
				echo "Done";
			}
			else
			{
						echo "fail";
			}
			
			

	
	}
	
	/*echo "<pre>";
	print_r($_POST);
	echo "</pre>";*/
	
	

		mysqli_close($conn);
		
?>



