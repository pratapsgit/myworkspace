package app

import (
	"fmt"
	"log"
	"net/http"

	"github.com/gorilla/mux"
)

func Start() {
	router := mux.NewRouter()

	router.HandleFunc("/greet", greet).Methods(http.MethodGet)
	router.HandleFunc("/students", getAllStudents).Methods(http.MethodGet)
	router.HandleFunc("/students/{student_id:[0-9]+}", getAStudent).Methods(http.MethodGet)

	fmt.Println("Server will be listening on port 8000...")
	log.Fatal(http.ListenAndServe("localhost:8000", router))
}
