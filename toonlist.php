<?php
 /*
 검색바(SB)의 문자열을 읽어와서 DB에서 조회 후 출력/Search 테이블 삭제
 */

    header("Content-Type:text/html; charset=UTF-8");
 
    $conn= mysqli_connect("localhost","webalarm","hanvit5692*","webalarm");
 
    mysqli_query($conn, "set names utf8");
 
    $SB = $_POST["SB"];
	$ID = $_POST["ID"];

	$sql= "	SELECT C_id, C_title, C_info,C_href, C_img, C_notice, C_date
			FROM content";

    $result=mysqli_query($conn, $sql);
 
    $rowCnt= mysqli_num_rows($result);
 
    $arr= array(); //빈 배열 생성
 
    for($i=0;$i<$rowCnt;$i++){
        $row= mysqli_fetch_array($result, MYSQLI_ASSOC);
        //각 각의 row를 $arr에 추가
        $arr[$i]= $row;
        
    }
 
    //배열을 json으로 변환하는 함수가 있음.
        $jsonData=json_encode($arr); //json배열로 만들어짐.
        echo "$jsonData";
 
    mysqli_close($conn);
?>