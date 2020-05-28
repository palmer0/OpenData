/**
 * La Palma Open Data
 * Portal de datos abiertos de la Isla de La Palma
 *
 * OpenAPI spec version: 1.0.0
 *
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */
package io.swagger.client.models

/**
 *
 * @param objectIdFieldName
 * @param globalIdFieldName
 * @param geometryType
 * @param spatialReference
 * @param fields
 * @param features
 */
data class ParadasTaxi(
    val objectIdFieldName: kotlin.String? = null,
    val globalIdFieldName: kotlin.String? = null,
    val geometryType: kotlin.String? = null,
    val spatialReference: SpatialReference? = null,
    val fields: kotlin.Array<Fields>? = null,
    val features: kotlin.Array<FeatureParadaTaxi>? = null
) {

}

