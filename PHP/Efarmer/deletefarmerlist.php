<?php
	
	include('fmconfig.php');
	
	$fr_id = "";
	if( (isset($_GET['fr_id'])))
	{
		$fr_id = $_GET['fr_id'];
	 $sql="DELETE FROM fregistration WHERE fr_id='".$fr_id."' ";
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


