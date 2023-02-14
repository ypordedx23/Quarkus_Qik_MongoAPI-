package ec.microdev;


public class Main {

/*
    @Inject
    UserRepository usRepository;

    @Route(path = "Hello", methods = Route.HttpMethod.GET)
    void hello(RoutingExchange ex){
        ex.ok("Hello "+ex.getParam("name"));
    }

    @Route(path="Users", methods = Route.HttpMethod.GET, produces = ReactiveRoutes.JSON_STREAM)
    @Timed
    @Counted
    @CacheName("users")
    Multi<User> getUser(){
        return Multi.createFrom().items(()->usRepository.listAll().stream()).runSubscriptionOn(Infrastructure.getDefaultWorkerPool());
    }

    @Transactional
    void serverInit(@Observes StartupEvent startupEvent){
        for (int i= 0; i <10000;i++){
            User us = new User();
            us.setId(UUID.randomUUID().toString());
            us.setUserName(RandomStringUtils.randomAlphabetic(10,15));
            us.setPassword(RandomStringUtils.randomAlphanumeric(10));
            usRepository.persistAndFlush(us);
        }
    }*/
}