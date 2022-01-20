package br.com.smartbot.testesmartbot.repository;

import br.com.smartbot.testesmartbot.vo.Coin;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CoinOneMinRepository extends PagingAndSortingRepository<Coin,Integer> {
}
