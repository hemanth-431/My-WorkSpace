import 'package:flutter/material.dart';
//import 'package:hemanth123/question.dart';
import './question.dart';
import './answer.dart';
void main() =>runApp(Myapp());



class Myapp extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    // TODO: implement createState
    return MyAppfirst();
  }
}
class MyAppfirst extends State<Myapp>{
 final questions=const[{'questionText':"hello?",'answer':["red","green","blue","violet"],},{
   'questionText':"hi?",'answer':["r","g","b","v"],
 },{'questionText':"bye?",'answer':["max","min","low","high"],}];
 var _questionindex=0;
 void _answerquestion()
 {

   setState(() {
     _questionindex=_questionindex+1;
   });
   print(_questionindex);

   if(_questionindex < questions.length){
     print("we have more questions");
   }
   else
   {
     print("no questions");
   }

 }
 @override
  Widget build(BuildContext context)
  {

    return MaterialApp(home: Scaffold(appBar: AppBar(title: Text("hello"),),
    body: _questionindex < questions.length ? Column(children:[question(questions[_questionindex]['questionText']),

      ...(questions[_questionindex]['answer'] as List<String>).map((answer)
      {return Answer(_answerquestion,answer);}).toList()
   /* RaisedButton(child: Text("answer1"),onPressed: _answerquestion,),
     // Text("The Question2!"),
      RaisedButton(child: Text("answer2"),onPressed:()=>print("Answer 2"),),
      Text("The Question3!"),
      RaisedButton(child: Text("answer3"),onPressed:(){
        print("hello");

      },),*/
   /* answer(_answerquestion),
    answer(_answerquestion),
    answer(_answerquestion)*/] ,): Center(child: Text("Not Matched"),),),);
  }
}