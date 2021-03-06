package test.json

import com.jetdrone.vertx.yoke.json.JsonSchema
import com.jetdrone.vertx.yoke.json.JsonSchemaResolver
import org.junit.Test

import static org.junit.Assert.assertFalse
import static org.junit.Assert.assertTrue

class MixedTest {

    @Test
    void it_should_validate() {
        assertTrue(
                JsonSchema.conformsSchema(
                        ['name': 'test', 'lines': ['1']],
                        new JsonSchemaResolver.Schema([
                                'type'      : 'object',
                                'properties': [
                                        'name' : ['type': 'string'],
                                        'lines': [
                                                'type' : 'array',
                                                'items': ['type': 'string']
                                        ]
                                ]
                        ])));
    }

    @Test
    void it_should_not_validate() {
        assertFalse(
                JsonSchema.conformsSchema(
                        ['name': 'test', 'lines': [1]],
                        new JsonSchemaResolver.Schema([
                                'type'      : 'object',
                                'properties': [
                                        'name' : ['type': 'string'],
                                        'lines': [
                                                'type' : 'array',
                                                'items': ['type': 'string']
                                        ]
                                ]
                        ])));
    }
}
