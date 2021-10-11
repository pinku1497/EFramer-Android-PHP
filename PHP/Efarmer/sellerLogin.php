<?php
	
	include "fmconfig.php";
	
	$sremail=$_GET['sremail'];
	$srpassword=$_GET['srpassword'];

	
	$sql="insert into sellerlogin(sremail,srpassword)values('$sremail','$srpassword')";
	
	
	$res=mysqli_query($conn,$sql);
	$result=array();
	if($res)
	{
		array_push($result,
							array('status'=>1,
								'msg'=>"Login Succesfully.."));
	}
	else
	{
		array_push($result,
							array('status'=>0,
							'msg'=>"Login unsucces,TRY Again"));
	}

	echo json_encode(array("result"=>$result));
	
	
	
?>