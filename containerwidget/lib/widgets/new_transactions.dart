import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

 class newtransaction extends StatefulWidget {
  final Function addtx;
newtransaction(this.addtx);
  @override
  _newtrans createState() => _newtrans();
}
class _newtrans extends State<newtransaction> {

  final titlecontroler = TextEditingController();
  final amountcontroler = TextEditingController();

  void submitdata()
    {
      final enteredtitle = titlecontroler.text;
      final enteramount = double.parse(amountcontroler.text);
      if (enteredtitle.isEmpty || enteramount <= 0) {
        return;
      }
      widget.addtx(enteredtitle, enteramount);
      Navigator.of(context).pop();
    }
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return Card(
      elevation: 5,
      child: Container(
        padding: EdgeInsets.all(10),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.end,

          children: <Widget>[

            TextField(decoration: InputDecoration(labelText: 'Title'),
              controller: titlecontroler,
              onSubmitted: (_)=>submitdata(),
              // onChanged: (val){
              //   titleinput=val;
              // },

            ),

            TextField(decoration: InputDecoration(labelText: 'Amount'),
              controller: amountcontroler,
              keyboardType: TextInputType.number,
              onSubmitted: (_) => submitdata,
              //  onChanged: (val1){
              //  amountinput=val1;
              //  },
            ),
            FlatButton(child: Text('Add Transaction'),
              textColor: Colors.purple,
              onPressed: submitdata,),
          ],),),);
  }

}