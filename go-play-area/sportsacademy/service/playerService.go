package service

import (
	"github.com/pratapsgit/myworkspace/go-play-area/sportsacademy/domain"
)

type PlayerService interface {
	GetAllPlayers() ([]domain.Player, error)
}

type DefaultPlayerService struct {
	repo domain.PlayerRepository
}

func (p DefaultPlayerService) GetAllPlayers() ([]domain.Player, error) {
	return p.repo.FindAll()
}

func NewPlayerService(repository domain.PlayerRepository) DefaultPlayerService {
	return DefaultPlayerService{repository}
}
