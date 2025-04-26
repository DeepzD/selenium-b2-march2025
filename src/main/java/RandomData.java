import net.datafaker.Faker;
import net.datafaker.providers.base.Address;

public class RandomData {

        Faker faker =new Faker();

        public String getFirstname() {
            return faker.name().firstName();
        }

        public String getLastname() {
            return faker.name().lastName();
        }

        public String getZipCode() {
            return faker.address().zipCode();
        }

}
