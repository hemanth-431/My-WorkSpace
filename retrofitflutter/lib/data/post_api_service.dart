import 'package:chopper/chopper.dart';
part 'post_api_service.chopper.dart';

@ChopperApi(baseUrl: '/posts')
abstract class PostApiService extends ChopperService {
  @Get()//@Get(headers: {'abc' : 'cba'})
  Future<Response<Post>> getPosts();


  @Get(path:'/{id}')
  Future<Response> getPost(@Path('id') int id);

  @Post()
  Future<Response> postPost(
      @Body() Map<String,dynamic> body,
      );
  static PostApiService create(){
    final clint=ChopperClient(baseUrl:'https://jsonplaceholder.typicode.com',services: [_$PostApiService()],converter: JsonConverter(), );
    return _$PostApiService(clint);
  }
}

/*Future<Response<Post>> getPost();
}
class Post{

}

@Post()
@Put
@Patch()
@Delete()
 */