package domain

import (
	"database/sql"
	"fmt"
	"log"
	"time"

	_ "github.com/go-sql-driver/mysql"
)

type PlayerRepositoryDb struct {
	db *sql.DB
}

func (p PlayerRepositoryDb) FindAll() ([]Player, error) {

	findAllSql := "select player_id, name, city, zipcode, status, date_of_birth from players"

	data, err := p.db.Query(findAllSql)
	if err != nil {
		log.Println("Error while querying the players table" + err.Error())
		return nil, err
	}

	players := make([]Player, 0)
	for data.Next() {
		var p Player

		err := data.Scan(&p.Id, &p.Name, &p.City, &p.ZipCode, &p.Status, &p.DateOfBirth)
		if err != nil {
			log.Println("Error while scanning the players table" + err.Error())
			return nil, err
		}

		players = append(players, p)
	}

	return players, nil
}

func NewPlayerRepositoryDb() PlayerRepositoryDb {
	db, err := sql.Open("mysql", "root:Mailme@09@tcp(localhost:3306)/sportsdb")
	if err != nil {
		fmt.Println("Unable to create a connection with MySql Server")
		panic(err)
	}

	// See "Important settings" section.
	db.SetConnMaxLifetime(time.Minute * 3)
	db.SetMaxOpenConns(10)
	db.SetMaxIdleConns(10)

	return PlayerRepositoryDb{db}
}
