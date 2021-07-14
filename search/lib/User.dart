class User{

  String FullName;
  String MailId;
  User({this.FullName,this.MailId});
  factory User.fromJson(Map<String,dynamic> json){
    return User(

      FullName: json["FullName"] as String,
      MailId: json["MailId"] as String,

    );
  }
}