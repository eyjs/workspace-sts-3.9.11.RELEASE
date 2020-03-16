/*
Student = function(id, name, kor, eng, math) {
	this.id = id;
	this.name = name;
	this.kor = kor;
	this.eng = eng;
	this.math = math;
	this.tot = 0;
	this.avg = 0.0;
}
*/
function Student(id, name, kor, eng, math) {
	this.id = id;
	this.name = name;
	this.kor = kor;
	this.eng = eng;
	this.math = math;
	this.tot = 0;
	this.avg = 0.0;
}
Student.prototype.calculateTot = function() {
	this.tot = this.kor + this.eng + this.math;
}
Student.prototype.calculateAvg = function() {
	this.avg = this.tot / 3.0;
}
Student.prototype.toString = function() {
	return '[' + this.id + ']' + this.name + "," + this.kor + "," + this.eng
			+ "," + this.math + "," + this.tot + "," + this.avg;
}