package app

import (
	"log"
	"net/http"

	"github.com/gorilla/mux"
	"github.com/pratapsgit/myworkspace/go-play-area/sportsacademy/domain"
	"github.com/pratapsgit/myworkspace/go-play-area/sportsacademy/service"
	"github.com/pratapsgit/myworkspace/go-play-area/sportsacademy/sports"
)

func Start() {
	router := mux.NewRouter()

	ph := sports.PlayerHandlers{Playerservice: service.NewPlayerService(domain.NewPlayerRepositoryStub())}
	router.HandleFunc("/players", ph.GetAllPlayers)

	log.Fatal(http.ListenAndServe("localhost:8090", router))
}
