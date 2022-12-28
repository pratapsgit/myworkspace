package app

import (
	"fmt"
	"log"
	"net/http"
)

func Start() {
	http.HandleFunc("/greet", greet)
	http.HandleFunc("/students", getAllStudents)

	fmt.Println("Server will be listening on port 8000...")
	log.Fatal(http.ListenAndServe("localhost:8000", nil))
}
