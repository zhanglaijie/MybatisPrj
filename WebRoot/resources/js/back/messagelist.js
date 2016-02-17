function deleteBatch(path){
	$("#mainForm").attr("action", path+"DeleteBatch.action");
	//DeleteOne.action?id=${message.id}"
	$("#mainForm").submit();
}
function deleteOne(path){
	$("#mainForm").attr("action", path+"DeleteOne.action");
	$("#mainForm").submit();
}