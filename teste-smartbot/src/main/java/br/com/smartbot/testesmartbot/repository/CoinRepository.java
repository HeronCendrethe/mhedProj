package br.com.smartbot.testesmartbot.repository;

import br.com.smartbot.testesmartbot.vo.Coin;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CoinRepository extends PagingAndSortingRepository<Coin,Integer> {
}
