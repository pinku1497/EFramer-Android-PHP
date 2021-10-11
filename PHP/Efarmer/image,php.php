<?php

	include "fmconfig.php";
	
		header('Content-type:bitmap; charset-utf-8');
		
		if(isset($_POST["encoded_string"]))
		{
			$encoded_string=$POST_["encoded_string"];
			$image_name=$_POST["image"];
			
			$decoded_string=base64_decode($encoded_string);
			
			$path='uploadimages/'.$image;
			
			$file=fopen($path,'wb');
			
			$is_written=fwrite($file,$decoded_string);
			fclose($file);
			
			if($is_written>0)
			{
					$query="insert into sproduct(fertname,image,path,rate,description)
					        values('$fertname','$image','$path','$rate','$description')";
							
							$result=mysqli_query($conn,$query);
							if($result)
							{
								echo "Success";
								
							}
							else
							{
								echo "fail";
							}
							mysqli_close($conn);
			}
		}
?>