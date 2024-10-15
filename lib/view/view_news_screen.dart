import 'package:flutter/material.dart';
import 'package:sdaassignmenttwo/view/news_screen.dart';
class ViewNewsScreen extends StatefulWidget {
  const ViewNewsScreen({super.key});

  @override
  State<ViewNewsScreen> createState() => _ViewNewsScreenState();
}

class _ViewNewsScreenState extends State<ViewNewsScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(),
      body:
          Center(
            child: ElevatedButton(
              onPressed: (){
                Navigator.push(context, MaterialPageRoute(builder: (context)=>NewsScreen()));
              },
              child: Text("View News"),
            ),
          ),

    );
  }
}
