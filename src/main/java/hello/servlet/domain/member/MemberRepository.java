package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {
    /** 동시성 문제가 고려되지 않고 있으며 ,실무에서는 ConcurrentHashMap,AtomicLong사용을 고려하자 */
    private Map<Long,Member> store=new HashMap<>();
    private static Long sequence=0L;

    //싱글톤 패턴으로 서블릿 컨테이너에서 하나의 저장소만 동작한다.
    private static final MemberRepository instance=new MemberRepository();

    //Singleton에서 생성자를 호출하지 못하도록 private으로 제한
    private MemberRepository(){}

    public static MemberRepository getInstance() {
        return instance;
    }
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);

        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
