package app

import (
	"fmt"
	"log"
	"net/http"
)

func Start() {
	mux := http.NewServeMux()

	mux.HandleFunc("/greet", greet)
	mux.HandleFunc("/students", getAllStudents)

	fmt.Println("Server will be listening on port 8000...")
	log.Fatal(http.ListenAndServe("localhost:8000", mux))
}
