import 'package:containerwidget/widgets/new_transactions.dart';
import 'package:containerwidget/widgets/transaction_list.dart';
import 'package:flutter/material.dart';

import 'model/container.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter App',
      theme: ThemeData(primarySwatch: Colors.blue,accentColor: Colors.orangeAccent,fontFamily: 'Quicksand',
       //   textTheme: ThemeData.light().textTheme.copyWith(title: TextStyle(fontFamily: 'OpenSans',fontWeight: FontWeight.bold,fontSize: 18)),
          appBarTheme: AppBarTheme(textTheme:ThemeData.light().textTheme.copyWith(title: TextStyle(fontFamily: 'OpenSans',fontSize: 20,fontWeight: FontWeight.bold,)))),


      home: MyHomePage(),
    );
  }
}


class  MyHomePage extends StatefulWidget {


//String amountinput;
  @override
  _MyHomePageState createState() => _MyHomePageState();
}
class _MyHomePageState extends State<MyHomePage>{
  final List<container> _user=[

    container(id:'t1',title:'new shoes',amount:69.99,date:DateTime.now(),),
    container(id:'t2',title: 'weekly grouchery',amount: 88.99,date: DateTime.now(),),
  ];

  void _addnew(String txtitle,double txamount)
  {
    final newtxt=container(title: txtitle,amount: txamount,date: DateTime.now(),id: DateTime.now().toString());

    setState(() {
      _user.add(newtxt);
    });
  }

  void _startaddnewtrans(BuildContext ctx)
  {
    showModalBottomSheet(context: ctx, builder: (_){
      return newtransaction(_addnew);
    },);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(

        // Here we take the value from the MyHomePage object that was created by
        // the App.build method, and use it to set our appbar title.
        title: Text('Flutter app' ),
        actions: <Widget>[IconButton(icon: Icon(Icons.add),onPressed: ()=>_startaddnewtrans(context),),],
      ),
      body: SingleChildScrollView(
        child: Column(
          //mainAxisAlignment: MainAxisAlignment.start,

          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: <Widget>[
          Container( width:double.infinity,
         child: Card(
            color: Colors.blue,
             child: Text("CHART"),elevation: 5,),),
           TransactionList(_user),

    ],),
      ),
    floatingActionButtonLocation: FloatingActionButtonLocation.centerFloat,
    floatingActionButton: FloatingActionButton(child: Icon(Icons.add_shopping_cart),onPressed: ()=>_startaddnewtrans(context),),
    );


  }

  @override
  State<StatefulWidget> createState() {
    // TODO: implement createState
    return null;
  }
}
