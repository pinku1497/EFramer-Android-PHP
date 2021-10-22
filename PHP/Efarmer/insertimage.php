//not working this api
<?php
defined('ROOT_PATH')  OR define('ROOT_PATH', $_SERVER['DOCUMENT_ROOT']."/efarmer_apis/");

defined('TRANSPORTERS_DOCS_UPLOAD_PATH')  OR define('TRANSPORTERS_DOCS_UPLOAD_PATH', ROOT_PATH."upload/");

			include "fmconfig.php"
			
                  
				 $file_name_image = "";
                  
				$image = $_GET['image'];
				
				$sql="insert into sproduct(image)values('$image')";
                    // For License
                    if(isset($image) && ($image != ""))
                    {                        
                        list($type, $image) = explode(';', $image);
                        list(, $image)      = explode(',', $image);

                        list($type1, $ext) = explode('/', $type);

                        $file_name_image = "license-".$image_id.".".$ext;
                        $upload_doc_license = TRANSPORTERS_DOCS_UPLOAD_PATH.$file_name_image;

                        $image = base64_decode($image);
                        $liu_success = file_put_contents($upload_doc_license, $image);
				
	$res=mysqli_query($conn,$sql);
	$result=array();
	if($res)
	{
		array_push($result,
							array('status'=>1,
								'msg'=>"Registration Succesfully.."));
	}
	else
	{
		array_push($result,
							array('status'=>0,
							'msg'=>"Registration unsucces,TRY Again"));
	}

	echo json_encode(array("result"=>$result));
                    }
?>
