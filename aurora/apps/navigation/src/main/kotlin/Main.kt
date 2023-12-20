import helloworld.GreeterWireGrpc
import helloworld.HelloReply
import helloworld.HelloRequest

import io.grpc.ServerBuilder

public class GrpcImpl : GreeterWireGrpc.GreeterImplBase() {
    override suspend fun SayHello(request: HelloRequest): HelloReply {
        return HelloReply("Hello ${request.name}")
    }
}

public fun main(args: Array<String>) {
    val server = ServerBuilder.forPort(8090)
        .addService(GrpcImpl())
        .build()
    //https://github.com/square/wire/blob/master/samples/wire-grpc-sample/server-plain/src/main/java/com/squareup/wire/whiteboard/WhiteboardImpl.kt

    println("Starting server...")
    server.start()
    server.awaitTermination()



    /*
    val connection = CassandraConnection(Configuration())
    Seeding(connection).seed()
    CassandraRepository(connection).getEntries().forEach {
        println(it)
    }
    connection.close()*/
    //https://github.com/apache/cassandra-java-driver/tree/4.x/manual/query_builder
    //https://rnett.github.io/krosstalk/release/
}
