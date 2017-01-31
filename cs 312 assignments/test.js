function printEncryptedString (str, columns) {
	var result = "";
	for (var i = 0; i < columns; i++) {
		result += line(str, i, columns);
		console.log(result);
	}
}

function line (str, index, columns) {
	var result = "";
	for (var i = index; index < str.length; index += columns) {
		result += str.indexOf(i);
	}
}

printEncryptedString("brian", 2);