<?php

include "fmconfig.php";
	
	$name=$_GET['name'];
	$image=$_GET['image'];

	 
	$sql="insert into image(name,image)values('$name','$image')";
	
    $stmt = mysqli_prepare($conn,$sql);
    
    mysqli_stmt_bind_param($stmt,"s",$image);
    mysqli_stmt_execute($stmt);
    
    $check = mysqli_stmt_affected_rows($stmt);
    
    if($check == 1)
	{
        echo "Image Uploaded Successfully";
    }
	else
	{
        echo "Error Uploading Image";
    }
       // mysqli_close($conn);
		

	echo json_encode(array("result"=>$check));
	
	?>